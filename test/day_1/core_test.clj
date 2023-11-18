(ns day-1.core-test
  (:require 
   [clojure.test :refer [deftest is]]
   [day-1.core :as core]
   [day-1.data :as data]))

(deftest returns-24000-for-example-input
  (let [input (data/create-input [[1000 2000 3000]
                                  [4000]
                                  [5000 6000]
                                  [7000 8000 9000]
                                  [10000]])]

    (is (= 24000 (core/find-most-calories input)))))

(deftest returns-nil-when-no-elves-carry-calories
  (is (nil? (core/find-most-calories (data/create-input [])))))

(deftest returns-calories-from-single-elve-carrying-one-food
  (let [input (data/create-input [[1]])]
    
    (is (= 1 (core/find-most-calories input)))))

(deftest returns-calories-from-elve-carrying-higher-calory-food
  (let [input (data/create-input [[1] [2]])]

    (is (= 2 (core/find-most-calories input)))))

(deftest returns-calories-from-elve-carrying-most-combined-calories
  (let [input (data/create-input [[1 2] [2]])]

    (is (= 3 (core/find-most-calories input)))))