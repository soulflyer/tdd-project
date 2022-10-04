(ns tdd-project.spiral-test
  (:require
    [clojure.test :as t]
    [tdd-project.spiral :as sut]))

(t/deftest support-functions-test
  (t/testing "Modify the center of the spiral matrix for expansion"
    (t/is (= [[13 14]
              [16 15]]
             (sut/modify-center
               [[1 2]
                [4 3]])))
    (t/is (= [[17 18 19]
              [24 25 20]
              [23 22 21]]
             (sut/modify-center
               [[1 2 3]
                [8 9 4]
                [7 6 5]])))
    (t/is (= [[25 26 27 28 29]
              [40 41 42 43 30]
              [39 48 49 44 31]
              [38 47 46 45 32]
              [37 36 35 34 33]]
             (sut/modify-center
               [[1  2  3  4  5]
                [16 17 18 19 6]
                [15 24 25 20 7]
                [14 23 22 21 8]
                [13 12 11 10 9]]))))

  (t/testing "Prepare wrapping"
    (t/is (= {:first-row [1 2 3]
              :last-row [7 6 5]
              :right-column [4]
              :left-column [8]}
             (sut/prepare-wrapping 1)))
    (t/is (= {:first-row [1 2 3 4]
              :last-row [10 9 8 7]
              :right-column [5 6]
              :left-column [12 11]}
             (sut/prepare-wrapping 2)))
    (t/is (= {:first-row [1 2 3 4 5]
              :last-row [13 12 11 10 9]
              :right-column [6 7 8]
              :left-column [16 15 14]}
             (sut/prepare-wrapping 3))))

  (t/testing "Wrap the modified center spiral"
    (t/is (= [[1 2 3]
              [8 9 4]
              [7 6 5]]
             (sut/wrap-spiral
               [[9]]
               {:first-row [1 2 3]
                :last-row [7 6 5]
                :right-column [4]
                :left-column [8]})))
    (t/is (= [[1  2  3  4]
              [12 13 14 5]
              [11 16 15 6]
              [10 9  8  7]]
             (sut/wrap-spiral
               [[13 14]
                [16 15]]
               {:first-row [1 2 3 4]
                :last-row [10 9 8 7]
                :right-column [5 6]
                :left-column [12 11]})))
    (t/is (= [[1  2  3  4  5]
              [16 17 18 19 6]
              [15 24 25 20 7]
              [14 23 22 21 8]
              [13 12 11 10 9]]
             (sut/wrap-spiral
               [[17 18 19]
                [24 25 20]
                [23 22 21]]
               {:first-row [1 2 3 4 5]
                :last-row [13 12 11 10 9]
                :right-column [6 7 8]
                :left-column [16 15 14]}))))

  (t/testing "Expand spiral matrices"
    (t/is (= [[1 2] [4 3]] (sut/expand-spiral [])))
    (t/is (= [[1  2  3  4]
              [12 13 14 5]
              [11 16 15 6]
              [10 9  8  7]]
             (sut/expand-spiral
               [[1 2]
                [4 3]])))
    (t/is (= [[1 2 3]
              [8 9 4]
              [7 6 5]]
             (sut/expand-spiral [[1]])))
    (t/is (= [[1  2  3  4  5]
              [16 17 18 19 6]
              [15 24 25 20 7]
              [14 23 22 21 8]
              [13 12 11 10 9]]
             (sut/expand-spiral
               [[1 2 3]
                [8 9 4]
                [7 6 5]])))))

(t/deftest spiral-test
  (t/testing "Testing spiral matrix is correctly returned."
    (t/is (= [[1]] (sut/spiral 1)))
    (t/is (= [[1 2]
              [4 3]]
             (sut/spiral 2)))
    (t/is (= [[1 2 3]
              [8 9 4]
              [7 6 5]]
             (sut/spiral 3)))
    (t/is (= [[1  2  3  4]
              [12 13 14 5]
              [11 16 15 6]
              [10 9  8  7]]
             (sut/spiral 4)))
    (t/is (= [[1  2  3  4  5]
              [16 17 18 19 6]
              [15 24 25 20 7]
              [14 23 22 21 8]
              [13 12 11 10 9]]
             (sut/spiral 5)))))

(comment
  [[1 2]
   [4 3]]
  
 [[1  2  3  4]
  [12 13 14 5]
  [11 16 15 6]
  [10 9  8  7]]

 [[ 1  2  3  4  5  6]
  [20 21 22 23 24  7]
  [19 32 33 34 25  8]
  [18 31 36 35 26  9]
  [17 30 29 28 27 10]
  [16 15 14 13 12 11]]

 (sut/prepare-wrapping 0)
 (sut/expand-spiral [])
 (sut/modify-center
   [[1 2]
   [4 3]])

 [[49]] (- (* n n) (* (- n 2) (- n 2)))

 [[1  2  3  4  5]
  [16 17 18 19 6]
  [15 24 25 20 7]
  [14 23 22 21 8]
  [13 12 11 10 9]]

 [[1 2 3]
  [8 9 4]
  [7 6 5]]

 [[1]] (- (* n n) (* (- n 2) (- n 2)))

 (let [n 5]
   (- (* n n) (* (- n 2) (- n 2))))

 [[1  2  3  4  5]
  [_  17 18 19 _]
  [_  _  25 _  _]
  [_  23 22 21 _]
  [13 12 11 10 9]]


 (* n n)
 (range 1 (inc n))
 (range (- (* 4 n) 4) )


 [1 2 3 4]
 [_ 13 14 _]
 )
