(ns day-2.core-2 
  (:require [clojure.string :as string]))

(defn character->oponent-choice
  [choice]
  (case choice
    \A :rock
    \B :paper
    \C :scissors))

(defn character->outcome
  [choice]
  (case choice
    \X :loss
    \Y :draw
    \Z :win))

(defn outcome->choice
  [oponent-choice strategy]
  (get-in {:paper {:win :scissors
                   :draw :paper
                   :loss :rock}
           :rock {:win :paper
                  :draw :rock
                  :loss :scissors}
           :scissors {:win :rock
                      :draw :scissors
                      :loss :paper}}
          [oponent-choice strategy]))

(defn outcome->points
  [outcome]
  (case outcome
    :win 6
    :draw 3
    :loss 0))

(defn choice->points
  [our-choice]
  (let [choice-mappings {:rock 1
                         :paper 2
                         :scissors 3}]
    (our-choice choice-mappings)))


(defn calculate-points-for-strategy
  [strategy]
  (let [oponent-choice (character->oponent-choice (first strategy))
        outcome (character->outcome (nth strategy 2))
        our-choice (outcome->choice oponent-choice outcome)]
    (+ (outcome->points outcome)
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