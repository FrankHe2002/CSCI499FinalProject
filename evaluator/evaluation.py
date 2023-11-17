# Modified from calc_code_bleu.py

import argparse
import CodeBLEU.bleu as bleu
import CodeBLEU.weighted_ngram_match as weighted_ngram_match
import CodeBLEU.syntax_match as syntax_match
import CodeBLEU.dataflow_match as dataflow_match

def invert(a):
    # a is a list of lists. Invert it.
    return list(map(list, zip(*a)))

def score(pred, actual, hyper=(0.25, 0.25, 0.25, 0.25)): # alpha, beta, gamma, theta
    # pred/actual are lists of strings (lines)

    # First, make sure x and y have the same length by padding
    if len(pred) < len(actual):
        pred += [''] * (len(actual) - len(pred))
        print("[WARN] Padding prediction to match actual length.")
    elif len(pred) > len(actual):
        actual += [''] * (len(pred) - len(actual))
        print("[WARN] Padding actual to match prediction length.")

    # calculate ngram match (BLEU).
    # We're supposed to pass in a list of (list of (list of token)) as
    # reference and a list of (list of token) as hypothesis, where references[i] = list of references
    # for hypothesis[i], and references[i][j] is a list of tokens corresponding to the list of tokens hypothesis[i].

    # For us, each line is a hypothesis, and we only have one reference for each line.

    tokenized_hyps = [x.split() for x in pred]
    tokenized_refs = [[x.split()] for x in actual]

    ngram_match_score = bleu.corpus_bleu(tokenized_refs,tokenized_hyps)

    # calculate weighted ngram match
    keywords = [x.strip() for x in open('CodeBLEU/keywords/java.txt', 'r', encoding='utf-8').readlines()]
    def make_weights(reference_tokens, key_word_list):
        return {token:1 if token in key_word_list else 0.2 for token in reference_tokens}
    tokenized_refs_with_weights = [[[reference_tokens, make_weights(reference_tokens, keywords)] for reference_tokens in reference] for reference in tokenized_refs]
    weighted_ngram_match_score = weighted_ngram_match.corpus_bleu(tokenized_refs_with_weights, tokenized_hyps)

    # calculate syntax match
    syntax_match_score = syntax_match.corpus_syntax_match(invert([actual]), pred, "java")

    # calculate dataflow match
    dataflow_match_score = dataflow_match.corpus_dataflow_match(invert([actual]), pred, "java")

    code_bleu_score = hyper[0] * ngram_match_score\
                    + hyper[1] * weighted_ngram_match_score\
                    + hyper[2] * syntax_match_score\
                    + hyper[3] * dataflow_match_score

    print('ngram match: {0}, weighted ngram match: {1}, syntax_match: {2}, dataflow_match: {3}'.\
                        format(ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score))
    print('CodeBLEU score: ', code_bleu_score)

    return (ngram_match_score, weighted_ngram_match_score, syntax_match_score, dataflow_match_score), code_bleu_score

# a = ['public static void main ( String[] args ) {', 'int x = 5;', 'return y; }']
# b = ['public static void main ( String[] args ) {', 'int x = 3;', 'return x; }']
# c = ['public static void main ( String[] args ) { System.out.println( " Hello " ); return 0; }']
# print(score(a, c, hyper=(0.25, 0.25, 0.25, 0.25)))

# Read files
def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('--pred', type=str, required=True, help='path to prediction file')
    parser.add_argument('--actual', type=str, required=True, help='path to actual file')
    parser.add_argument('--hyper', type=str, default='0.25,0.25,0.25,0.25', help='hyperparameters for CodeBLEU')
    args = parser.parse_args()

    pred = open(args.pred, 'r', encoding='utf-8').readlines()
    actual = open(args.actual, 'r', encoding='utf-8').readlines()
    hyper = [float(x) for x in args.hyper.split(',')]

    score(pred, actual, hyper)
    
if __name__ == '__main__':
    main()