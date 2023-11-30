(ns day-4.core
  (:require 
   [clojure.string :as string]))

(defn parse-assignment
  [raw-assignment]
  (let [[[_ from-1 to-1] [_ from-2 to-2]](re-seq #"(\d+)-(\d+)" raw-assignment)]
    [[(Integer/parseInt from-1) (Integer/parseInt to-1)]
     [(Integer/parseInt from-2) (Integer/parseInt to-2)]]))

(defn parse-assignments
  [raw-assignments]
  (map parse-assignment (string/split-lines raw-assignments)))

(defn fully-overlaps?
  [[[from-1 to-1] [from-2 to-2]]]
  (or (and (>= from-1 from-2) (<= to-1 to-2))
      (and (>= from-2 from-1) (<= to-2 to-1))))

(defn count-overlaps-in-assignments
  [raw-assignments]
  (->> raw-assignments
       parse-assignments
       (filter fully-overlaps?)
       (count)))

(count-overlaps-in-assignments (slurp "./src/day_4/input.txt"))