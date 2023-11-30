(ns day-3.core-2-test
  (:require 
   [clojure.test :refer [deftest is are]]
   [clojure.string :as string]
   [day-3.core-2 :as core]))

(deftest returns-70-for-example-input
  (let [rucksacks (string/join "\n" ["vJrwpWtwJgWrhcsFMMfFFhFp"
                                 "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
                                 "PmmdzqPrVvPwwTWBwg"
                                 "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
                                 "ttgJtRGJQctTZtZT"
                                 "CrZsJsPPZsGzwwsLwLmpwMDw"])]
    
    (is (= 70 (core/sum-badge-priorities rucksacks)))))

(deftest returns-1-badge-a 
  (let [rucksacks (string/join "\n" ["ab"
                                     "ac"
                                     "ad"])]

    (is (= 1 (core/sum-badge-priorities rucksacks)))))