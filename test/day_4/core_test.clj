(ns day-4.core-test
  (:require [clojure.test :refer [deftest is]]
            [day-4.core :as core]))

(deftest does-not-count-no-overlap
  (let [assignments "1-1,2-2"]
    (is (= 0 (core/count-overlaps-in-assignments assignments)))))

(deftest  counts-one-overlap
  (let [assignments "1-1,1-1"]
    (is (= 1 (core/count-overlaps-in-assignments assignments)))))

(deftest counts-multiple-overlaps 
  (let [assignments "2-8,3-7\n6-6,4-6" ]
    (is (= 2 (core/count-overlaps-in-assignments assignments)))))