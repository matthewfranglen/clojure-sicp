(ns sicp.core)

; Run with return:
; :nmap <CR> 0cp}

(defn improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(defn square [x]
  (* x x))

(defn cube [x]
  (* x x x))

(defn abs [x]
  ((if (>= x 0) + -) x))

(defn good-enough? [guess x]
  (< (abs (- (cube guess) x)) 0.001))

(defn cube-root-iter [guess x]
  (if (good-enough? guess x)
    guess
    (cube-root-iter (improve guess x)
               x)))

(double (cube-root-iter 1 10))

(double (cube-root-iter 1 0.01))

(double (cube-root-iter 1 1000000))
; took too long

(defn good-enough-guess-tracker? [guess new-guess]
  (let [guess-offset (abs (- guess new-guess))]
    (< (abs (/ guess-offset guess)) 0.01)))

(defn cube-root-guess-tracker [guess x]
  (let [new-guess (improve guess x)]
    (if (good-enough-guess-tracker? guess new-guess)
      new-guess
      (cube-root-guess-tracker new-guess x))))

(double (cube-root-guess-tracker 1 10))

(double (cube-root-guess-tracker 1 0.01))

(double (cube-root-guess-tracker 1 27))
; returns close to 3

(double (cube-root-guess-tracker 1 1000000))
; still took too long
