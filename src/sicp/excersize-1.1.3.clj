(ns sicp.core)

; Run with return:
; :nmap <CR> 0cp}

(defn sum-larger-squares [one two three]
  (letfn [(square [number] (* number number))]
    (cond (and (> one three) (> two three)) (+ (square one) (square two))
          (and (> one two) (> three two)) (+ (square one) (square three))
          :else (+ (square two) (square three)))))

(sum-larger-squares 1 2 3)

(sum-larger-squares 1 3 2)

(sum-larger-squares 2 1 3)

(sum-larger-squares 2 3 1)

(sum-larger-squares 3 1 2)

(sum-larger-squares 3 2 1)
