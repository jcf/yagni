(ns yagni.namespace-test
  (:require [clojure.test :refer :all]
            [yagni.namespace :as namesp]
            [yagni.sample-ns :as sample-ns]))

(def x "sample var")

(deftest var-name-works
  (is (= (namesp/var-name (var x))
         'yagni.namespace-test/x)))

(deftest qualified-interns-works
  (is (= (sort (namesp/qualified-interns 'yagni.sample-ns))
         '(yagni.sample-ns/form-for-testing-get
           yagni.sample-ns/x
           yagni.sample-ns/y))))

(deftest named-vars-map-works
  (is (= (namesp/named-vars-map ['yagni.sample-ns])
         {'yagni.sample-ns/x #{}
          'yagni.sample-ns/form-for-testing-get #{}
          'yagni.sample-ns/y #{}})))
