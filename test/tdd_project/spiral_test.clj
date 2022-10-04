(ns tdd-project.spiral-test
  (:require
    [clojure.test :as t]
    [tdd-project.spiral :as sut]))

(t/deftest spiral-test
  (t/testing "Testing spiral matrix is correctly returned."
    (t/is (= [[1]] (sut/spiral 1)))
    (t/is (= [1 2 3 4] (first (sut/spiral 4))))
    (t/is (= [13 12 11 10 9] (last (sut/spiral 5))))
    (t/is (= [10 9 8 7] (last (sut/spiral 4))))
    (t/is (= [[1 2] [4 3]] (sut/spiral 2)))
    (t/is (= [[1 2 3] [8 9 4] [7 6 5]] (sut/spiral 3)))
    (t/is (= [[1 2 3 4] [12 13 14 5] [11 16 15 6] [10 9 8 7]] (sut/spiral 4)))))
