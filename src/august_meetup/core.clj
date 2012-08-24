(ns august_meetup.core)

(defn translate [n]
  (cond
    (< 100 n)
    (str (translate (int (Math/floor (/ (double n) 100.0))))
         "-hundred and " (translate (int (mod n 100.0))))
    (= 0 n) "zero"
    (= 1 n) "one"
    (= 2 n) "two"
    (= 3 n) "three"
    (= 4 n) "four"
    (= 5 n) "five"
    (= 6 n) "six"
    (= 7 n) "seven"
    (= 8 n) "eight"
    (= 9 n) "nine"
    (= 10 n) "ten"
    (= 11 n) "eleven"
    (= 20 n) "twenty"
    (< 30 n 40) (str "thirty-" (translate (- n 30)))
    (= 30 n) "thirty"
    (<= 20 n) (str "twenty-" (translate (- n 20)))))
