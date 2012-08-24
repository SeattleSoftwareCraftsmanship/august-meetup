(ns august_meetup.core-test
  (:use clojure.test
        august_meetup.core))

(deftest translating-really-simple-numbers
  (is (= (translate 0) "zero"))
  (is (= (translate 9) "nine")))

(deftest translating-two-digit-numbers
  (is (= (translate 10) "ten"))
  (is (= (translate 11) "eleven"))
  (is (= (translate 20) "twenty"))
  (is (= (translate 21) "twenty-one"))
  (is (= (translate 22) "twenty-two"))
  (is (= (translate 40) "forty"))
  (is (= (translate 99) "ninety-nine")))

(deftest tranlating-big-numbers
  (is (= (translate 100) "one-hundred"))
  (is (= (translate 234) "two-hundred and thirty-four"))
  (is (= (translate 420) "four-hundred and twenty"))
  (is (= (translate 419) "four-hundred and nineteen"))
  (is (= (translate 500) "five-hundred")))