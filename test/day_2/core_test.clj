(ns day-2.core-test
  (:require
   [day-2.core :as core]
   [clojure.string :as string]
   [clojure.test :refer [deftest is]]))

(deftest returns-15-for-example-input
  (let [strategy (string/join "\n" ["A Y"
                               "B X"
                               "C Z"])]
    (is (= 15 (core/calculate-points strategy)))))

(deftest scores-8-for-paper-against-rock
  (let [strategy "A Y"]
    (is (= 8 (core/calculate-points strategy)))))

(deftest scores-4-for-rock-against-rock
  (let [strategy "A X"]
    (is (= 4 (core/calculate-points strategy)))))

(deftest scores-2-for-scissors-against-rock
  (let [strategy "A Z"]
    (is (= 3 (core/calculate-points strategy)))))

(deftest scores-9-for-scissors-against-paper
  (let [strategy "B Z"]
    (is (= 9 (core/calculate-points strategy)))))

(deftest scores-5-for-paper-against-paper
  (let [strategy "B Y"]
    (is (= 5 (core/calculate-points strategy)))))

(deftest scores-1-for-rock-against-paper
  (let [strategy "B X"]
    (is (= 1 (core/calculate-points strategy)))))

(deftest scores-7-for-rock-against-scissors
  (let [strategy "C X"]
    (is (= 7 (core/calculate-points strategy)))))

(deftest scores-6-for-scissors-against-scissors
  (let [strategy "C Z"]
    (is (= 6 (core/calculate-points strategy)))))

(deftest scores-2-for-paper-against-scissors
  (let [strategy "C Y"]
    (is (= 2 (core/calculate-points strategy)))))

(deftest scores-4-for-paper-against-scissors-twice
  (let [strategy "C Y\nC Y"]
    (is (= 4 (core/calculate-points strategy)))))
