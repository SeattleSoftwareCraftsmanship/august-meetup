(ns august_meetup.core)

(def single-digits ["zero" "one" "two" "three" "four"
                    "five" "six" "seven" "eight" "nine"])

(def teens {10 "ten" 11 "eleven" 12 "twelve" 13 "thirteen"
            14 "fourteen" 15 "fifteen" 16 "sixteen"
            17 "seventeen" 18 "eighteen" 19 "nineteen"})

(def tens {2 "twenty" 3 "thirty" 4 "forty" 5 "fifty"
           6 "sixty" 7 "seventy" 8 "eighty" 9 "ninety"})

(defn translate
  "Translates a number into it's English long form."
  [n]
  (if (decimal? n)
    (translate (int n)))
  (cond
    (<= n 9)
    (single-digits n)

    (<= 10 n 19)
    (teens n)

    (<= 20 n 99)
    (let [t (int (/ n 10))
          r (mod n 10)]
      (str (tens t)
           (when (not= 0 r)
             (str "-" (translate r)))))

    (<= 100 n)
    (let [h (int (/ n 100))
          r (mod n 100)]
      (str (translate h) "-hundred"
           (when (not= 0 r)
             (str " and " (translate r)))))))
