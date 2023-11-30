(ns day-1.core
  (:require 
   [clojure.string :as string]))

(defn parse-calories-by-elve
  [calories-by-elve] 
  (map (fn [food] (Integer/parseInt food))
       (string/split-lines calories-by-elve)))

(defn parse
  [calories-by-elves]
  (if (string/blank? calories-by-elves)
    []
    (let [parsed-blocks (clojure.string/split calories-by-elves #"\n\n")
          parsed (map parse-calories-by-elve parsed-blocks)]
      parsed)))

(defn sorted-calories
  [calories-by-elves]
  (let [calories-by-elves (parse calories-by-elves)
        calories-by-elve (map #(apply + %) calories-by-elves)]
   (sort > calories-by-elve)))

(defn find-most-calories
  [calories-by-elves]
 (first (sorted-calories calories-by-elves)))

(defn main
  []
  (let [input (slurp "./src/day_1/input.txt")]
    (find-most-calories input)))

;;Part two

(defn sum-calories-by-top-n
  [calories-by-elves n]
  (apply + (take n (sorted-calories calories-by-elves))))

(defn main-2
  []
  (let [input (slurp "./src/day_1/input.txt")]
    (sum-calories-by-top-n input 3)))
