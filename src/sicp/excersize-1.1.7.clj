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

(double (sqrt-iter 1 10))

(double (sqrt-iter 1 0.01))

(double (sqrt-iter 1 1000000))

(defn good-enough-guess-tracker? [guess new-guess]
  (let [guess-offset (abs (- guess new-guess))]
    (< (abs (/ guess-offset guess)) 0.01)))

(defn sqrt-iter-guess-tracker [guess x]
  (let [new-guess (improve guess x)]
    (if (good-enough-guess-tracker? guess new-guess)
      new-guess
      (sqrt-iter-guess-tracker new-guess x))))

(double (sqrt-iter-guess-tracker 1 10))

(double (sqrt-iter-guess-tracker 1 0.01))

(double (sqrt-iter-guess-tracker 1 1000000))
