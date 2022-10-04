(ns tdd-project.spiral)


(defn modify-center
  "Increase the numbers in m such that it will be
  the center of a larger spiral matrix."
  [m]
  (let [n (count (first m))
        diff (* 4 (inc n))]
    (map (fn [row]
           (map #(+ % diff) row))
         m)))


(defn prepare-wrapping
  "The wrapping consists of the values that must be
  added around the modified center to get the larger
  matrix."
  [n]
  (let [next-n (+ n 2)]
    {:first-row (range 1 (inc next-n))
     :last-row (reverse
                 (range (dec (* 2 next-n))
                        (dec (* 3 next-n))))
     :right-column (range (inc next-n)
                          (dec (* 2 next-n)))
     :left-column (reverse
                    (range (dec (* 3 next-n))
                           (- (* 4 next-n) 3)))}))


(defn wrap-spiral
  "Produces a larger spiral matrix by wrapping m with
  the given wrapping-components."
  [m {:keys [first-row
             last-row
             right-column
             left-column] :as _wrapping-components}]
  (let [middle-rows
        (map (fn [row left right]
               (concat [left] row [right]))
             m
             left-column
             right-column)]
    (concat
      [first-row]
      middle-rows
      [last-row])))


(defn expand-spiral
  "Expands the spiral matrix m."
  [m]
  (let [n (count (first m))
        modified-center (modify-center m)
        wrapping-components (prepare-wrapping n)]
    (wrap-spiral modified-center wrapping-components)))


(defn spiral
  "Constructs a square matrix with a size N × N containing
  integers from 1 to N * N in a spiral order, starting from
  top-left and in clockwise direction.

  # Example

  For n = 3, the output should be

  solution(n) =
  [[1, 2, 3],
  [8, 9, 4],
  [7, 6, 5]]

  # Input/Output

  [input] integer n

  Matrix size, a positive integer.

  Guaranteed constraints:
  0 ≤ n ≤ 100.

  [output] array.array.integer"
  ([n]
   (spiral (dec n) (if (odd? n) [[1]] [])))
  ([n m]
   (if (pos? n)
     (recur (- n 2) (expand-spiral m))
     m)))
