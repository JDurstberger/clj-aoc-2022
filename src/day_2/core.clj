(ns day-2.core 
  (:require [clojure.string :as string]))

(defn character->oponent-choice
  [choice]
  (case choice
    \A :rock
    \B :paper
    \C :scissors))

(defn character->our-choice
  [choice]
  (case choice
    \Y :paper
    \X :rock
    \Z :scissors))

(def outcomes
  {:paper {:scissors :win
           :paper :draw
           :rock :loss}
   :rock {:paper :win
          :rock :draw
          :scissors :loss}
   :scissors {:rock :win
              :scissors :draw
              :paper :loss}})

(defn outcome->points
  [outcome]
  (case outcome
    :win 6
    :draw 3
    :loss 0))

(defn outcome-points
  [oponent-choice our-choice]
  (outcome->points (get-in outcomes [oponent-choice our-choice])))

(defn choice->points
  [our-choice]
  (let [choice-mappings {:rock 1
                         :paper 2
                         :scissors 3}]
    (our-choice choice-mappings)))

(defn calculate-points-for-strategy
  [strategy]
  (let [oponent-choice (character->oponent-choice (first strategy))
        our-choice (character->our-choice (nth strategy 2))]
    (+ (outcome-points oponent-choice our-choice)
       (choice->points our-choice))))

(defn calculate-points
  [strategies]
  (apply + (map calculate-points-for-strategy
                (string/split-lines strategies))))

(defn main
  []
  (let [input (slurp "./src/day_2/input.txt")]
    (calculate-points input)))

(main)