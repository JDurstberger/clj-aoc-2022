(ns day-3.core 
  (:require [clojure.string :as string]))

(comment 
  (def lowercase-items
    [\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z])
  

  (def uppercase-items
    [\A \B \C \D \E \F \G \H \I \J \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z])
  

  (defn item->priority
    [item]
    (inc (.indexOf (concat lowercase-items uppercase-items) item))))

(defn lowercase?
  [c]
  (= (str c) (string/lower-case c)))

(defn item->priority
  "Returns 1-26 for a-z and 27-56 for A-Z"
  [item]
  (- (int item) (if (lowercase? item) 96 38)))

(defn rucksack->compartments
  [rucksack]
  (split-at (/ (count rucksack) 2) rucksack))

(defn first-item-in-both-compartments
  [[left-compartment right-compartment]]
  (first (filter (fn [item] ((set right-compartment) item))
                 left-compartment)))

(defn wrong-item-priority-in-rucksack
  [rucksack]
  (-> rucksack
      (rucksack->compartments)
      (first-item-in-both-compartments)
      (item->priority)))

(defn wrong-items-priority-sum
  [rucksacks]
  (apply + (map wrong-item-priority-in-rucksack (string/split-lines rucksacks))))

(wrong-items-priority-sum (slurp "./src/day_3/input.txt"))

