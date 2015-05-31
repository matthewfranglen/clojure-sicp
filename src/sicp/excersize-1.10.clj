(ns sicp.core)

; Run with return:
; :nmap <CR> 0cp}

(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (A (- x 1)
                 (A x (- y 1)))))

(A 1 10)

; 1024

(A 2 4)

; 65536

(A 3 3)

; 65536

(defn f [n] (A 0 n))

(f 1) ; 2

(f 2) ; 4

(f 3) ; 6

; 2n

(defn g [n] (A 1 n))

(g 1) ; 2

(g 2) ; 4

(g 3) ; 8

; (A 1 n) -> (A 0 (A 1 (- n 1)))
; (A 1 n) -> (* 2 (A 1 (- n 1))))
; repeats as many times as n is big, becoming 2 * 2 * 2 ... (A 1 1) [i.e. 2]
; means this is
; 2^n

(defn h [n] (A 2 n))

(h 1) ; 2

(h 2) ; 4

(h 3) ; 16

(h 4) ; 65536

; (A 2 n) -> (A 1 (A 2 (- n 1)))
; (A 2 n) -> (A 0 (- (A 1 (A 2 (- n 1))) 1))
;
; With (A 2 n) it becomes (A 1 n) where n is (A 2 (- n 1))
; So that is raising the power once for every time n gets smaller
; means this is
; ...
; (it's the inverse of log*)
; 2^2^2^2... n times
(defn my-h [n]
  (letfn [(raise [n acc]
            (if (= n 1)
              (Math/pow 2 acc)
              (raise (- n 1) (Math/pow 2 acc))))]
    (raise (- n 1) 2)))

(defn my-h [n]
  (if (= n 1)
    2
    (Math/pow 2 (my-h (- n 1)))))

(my-h 2) ; 4

(my-h 3) ; 16

(my-h 4) ; 65536

(defn k [n] (* 5 n n))

; 5(n^2)
