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

(defn find-most-calories
  [calories-by-elves]
  (let [calories-by-elves (parse calories-by-elves)
        calories-by-elve (map #(apply + %) calories-by-elves)
        sorted-calories-by-elve (sort > calories-by-elve)]
    
    (first sorted-calories-by-elve)))

(defn main
  []
  (let [input (slurp "./src/day_1/input.txt")]
    (find-most-calories input)))

