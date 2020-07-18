# Word Globe: Topic Indexer

![Logo](./logo.png)

- [Project Title] Word cloud visual model, word globe.

- [Deliverable Title] jaime-propose-define-reduce.md

## Abstract

This document explains the use of pairing a word with a definition
from the Urban Dictionary API.

- [Keywords] word, word-cloud, map, globe, earth.

## 1.1. Table of contents

1. [Summary] of the Topic Indexer for the Word Globe visualizer.
   1. [Table of contents]
   2. [Executive summary]
2. [Introduction] to the Topic Indexer.
   1.[General context]
   2.[A word on terms, assumptions and choices]
3. [Definition]
4. [Actors]
5. [Use cases]
6. [Logical view]
7. [Implementation details]
8. [Appendices]
9. [References]

## 1.2 Executive summary

This document explains how to prepare and associate words with
definitions of associated words. For every word, other words would be
categorized as either `Similar` or `Not Similar`. The words are defined through Urban Dictionary.

I develop fast graphics in OpenGL that might be ported onto a website
to enable optimal visualizations.

# 2. Introduction to the Topic Indexer.

## 2.1 General context

A `Topic Indexer` allows a viewer to increase the rate of
comprehension from a list of new terms. The `Word Globe` varient
allows a user to interact with a virtual globe of words linked and
bound by intersections of definitions of the words.

## 2.2 A word on terms, assumptions and choices

The reader must have prior knowledge of `Venn Diagrams` to understand
the graphics presented in this document.

# 3. Definition

The `Topic Indexer` must **get** the Urban Dictionary to define a word
calling `{defineWord}` on a REST API provided from a third-party.

As word blocks are accepted through a Configured Tool on Hadoop, the
key-value pair of the word-definition is constructed for a single
channel in Kafka. The visualizer selects smaller sets of managable
words to visualize similarities.

# 4. Actors

```
TextFile -> Kafka -> Configured Hadoop Tool -> Word Globe.
|-Sample--|------Topic Indexer---------------|-Visualizer|
```

The Configured Hadoop Tool is used to group and concatenate words from
an isolated context, using channels and offsets from Kafka.

Similarity is measured by the cardinality of inclusive unions when
inverting the map from word-definition onto
word-words-within-defintion.

# 5. Use cases

The visualizer could provide an overview of all
Tweets from a user, or the visualizer could provide an overarching
view of all Tweets from a group of Tweeters that have previously
interacted on a specific Tweet.

The `Topic Indexer` might be used to compare different candidates by
their level of shyness and aversion to ambiguous definitions of words.

# 6. Logical view

Pipe words through Kafka.

The Configured Tool in Hadoop provides a shell API to produce the
latest report.

# 7. Implementation details

The user interacts with shell scripts, and is able to scale on
clusters.

# 8. Appendices

None to be added.

# 9. References

Hadoop Source Wiki on GitHub.
