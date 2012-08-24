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
  (is (= (translate 22) "twenty-two")))

(deftest tranlating-big-numbers
  (is (= (translate 234) "two-hundred and thirty-four")))