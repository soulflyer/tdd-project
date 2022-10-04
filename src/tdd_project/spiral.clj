(ns tdd-project.spiral)

(defn spiral
  [n]
  (if (= 1 n)
    [[1]]
    [(range 1 (inc n))
     (reverse (range (+ n (- n 1)) (- (* 3 n) 1)))]))
