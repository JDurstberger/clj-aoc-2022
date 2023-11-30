(ns day-3.core-2 
  (:require [clojure.string :as string]))

(defn lowercase?
  [c]
  (= (str c) (string/lower-case c)))

(defn badge->priority
  "Returns 1-26 for a-z and 27-56 for A-Z"
  [item]
  (- (int item) (if (lowercase? item) 96 38)))

(defn find-badge-in-group
  [[rucksack-1 rucksack-2 rucksack-3]]
  (let [rucksack-1-2-overlaps (filter (set rucksack-1) rucksack-2)
        all-overlaps (filter (set rucksack-1-2-overlaps) rucksack-3)]
    (first all-overlaps)))

(defn input->groups
  [input]
  (partition 3 (string/split-lines input)))

(defn sum-badge-priorities
  [input]
  (let [groups (input->groups input)
        badges (map find-badge-in-group groups)
        priorities (map badge->priority badges)]
    (apply + priorities)))

(sum-badge-priorities (slurp "./src/day_3/input.txt"))

