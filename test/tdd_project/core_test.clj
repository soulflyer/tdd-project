(ns tdd-project.core-test
  (:require
    [clojure.test :refer :all]
    [tdd-project.core :refer :all]))

(def test-vector ["Iain" "Boldi" "World" "David" "John" "Pat" "Englebert"])

(deftest alphabetical
  (testing "Sort vector of strings in alphabetical order."
    (is (= [] (alphabetical-sort [])))
    (is (= ["Iain"] (alphabetical-sort ["Iain"])))
    (is (= ["Boldi" "David" "Englebert" "Iain" "John" "Pat" "World"] (alphabetical-sort test-vector)))))
