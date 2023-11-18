(ns day-1.data
  (:require
   [clojure.test :refer [deftest is]]
   [clojure.string :as string]))

(defn create-input
  [data]
  (let [blocks (map (fn [block-data] (string/join "\n" block-data))
                    data)]
    (string/join "\n\n" blocks)))

(deftest create-input-returns-calories-separated-by-newlines
  (is (= "1\n2\n\n3\n4" (create-input [[1 2] [3 4]]))))