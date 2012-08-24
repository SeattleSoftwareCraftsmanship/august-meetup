(ns august_meetup.core)

(defn translate [n]
  (cond
    (= 0 n) "zero"
    (= 1 n) "one"
    (= 2 n) "two"
    (= 9 n) "nine"
    (= 10 n) "ten"
    (= 11 n) "eleven"
    (= 20 n) "twenty"
    (<= 30 n) "thirty"
    (<= 20 n) (str "twenty-" (translate (- n 20)))))
