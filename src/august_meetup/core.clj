(ns august_meetup.core)

(def single-digits ["zero" "one" "two" "three" "four"
                    "five" "six" "seven" "eight" "nine"])

(def teens {10 "ten" 11 "eleven" 12 "twelve" 13 "thirteen"
            14 "fourteen" 15 "fifteen" 16 "sixteen"
            17 "seventeen" 18 "eighteen" 19 "nineteen"})

(def tens {20 "twenty" 30 "thirty" 40 "fourty" 50 "fifty"
           60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety"})

(defn translate [n]
  (if (decimal? n)
    (translate (int n)))
  (cond
    (<= n 9) (single-digits n)
    (<= 10 n 19) (teens n)
    (<= 20 n 99) (str (tens n)
                      (let [rem (mod n 10)]
                        (when (not= 0 rem)
                          (str "-" (translate rem)))))
    (< 100 n)
    (str (translate (Math/floor (/ (double n) 100.0)))
         "-hundred and " (translate (mod n 100)))))
