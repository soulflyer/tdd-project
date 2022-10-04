(ns tdd-project.spiral)


(defn spiral
  [n]
  (if (= 1 n)
    [[1]]
    [(range 1 (inc n))
     (reverse (range (+ n (- n 1)) (- (* 3 n) 1)))]))


(defn modify-center
  [m]
  (let [n (count (first m))
        diff (- (* (+ n 2) (+ n 2)) (* n n))]
    (map (fn [row]
           (map #(+ % diff) row))
         m)))


(defn prepare-wrapping
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
  [m {:keys [first-row
             last-row
             right-column
             left-column] :as _wrapping-components}]
  (concat
    [first-row]
    (map
      (fn [row left right]
        (concat [left] row [right]))
      m
      left-column
      right-column)
    [last-row]))


(defn expand-spiral
  [m]
  (let [n (count (first m))]
    (if (= n 0)
      [[1]]
      (let [modified-center (modify-center m)
            wrapping-components (prepare-wrapping n)]
        (wrap-spiral modified-center wrapping-components)))))
