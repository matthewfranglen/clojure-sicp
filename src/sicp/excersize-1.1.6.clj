(ns sicp.core)

; Run with return:
; :nmap <CR> 0cp}

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn square [x]
  (* x x))

(defn abs [x]
  ((if (>= x 0) + -) x))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(sqrt-iter 1 10)


(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn sqrt-iter-new-if [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter-new-if (improve guess x)
                            x)))

; infinite loop
(sqrt-iter-new-if 1 10)
