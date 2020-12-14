(ns halp.specs
  (:require [clojure.spec.alpha :as spec]
            [halp.core :as h]
            [halp.triggers :as t]
            [clojure.math.numeric-tower :as math]
            [clojure.string :as str]
            [clojure.walk :as walk]
            [clojure.set :as set]))

(spec/def :h/name string?)

(spec/def :h/event-type
  #{:guild-create :guild-update :guild-delete :guild-role-create
    :guild-role-update :guild-role-delete :channel-create :channel-update
    :channel-delete :channel-pins-update :guild-member-add :guild-member-update
    :guild-member-remove :guild-ban-add :guild-ban-remove :guild-emojis-update
    :guild-integrations-update :webhooks-update :invite-create :invite-delete
    :voice-state-update :presence-update :message-create :message-update
    :message-delete :message-delete-bulk :message-reaction-add
    :message-reaction-remove :message-reaction-remove-all
    :message-reaction-remove-emoji :typing-start})

(spec/def :h/numeric-operation
  (set '(;; Arithmetic
         + - * / quot rem mod inc dec max min
         ;; Comparisons & Tests
         == = < > <= >= compare zero? pos? neg? even? odd? number? rational?
         integer? ratio? decimal? float? double? int? nat-int? neg-int? pos-int?
         ;; Casts and Generation
         byte short int long float double bigdec bigint num rationalize
         biginteger rand rand-int
         ;; Higher Math
         math/ceil math/floor math/round math/integer-length math/sqrt math/abs
         math/exact-integer-sqrt math/expt math/gcd math/lcm)))

(spec/def :h/sequence-operation
  (set '(;; Sequence Creation
         seq vals keys rseq repeatedly iterate repeate range keep keep-indexed
         ;; Sequence to Sequence
         distinct filter remove take-nth for dedupe random-sample
         cons conj concat lazy-cat mapcat cycle interleave interpose
         rest nthrest next fnext nnext drop drop-while take-last
         take take-while butlast drop-last
         conj concat distinct flatten group-by partition partition-all
         partition-by split-at split-with filter remove replace shuffle
         reverse sort sort-by compare
         map map-indexed mapcat for replace
         ;; Sequence Usage
         first second last rest next ffirst nfirst fnext nnext nth nthnext
         rand-nth when-first max-key min-key
         zipmap into reduce reductions set vec mapv filterv
         apply some filter)))

(spec/def :h/string-operation
  (set '(;; Create
         str format
         ;; Use
         count get subs compare str/join str/escape str/split str/split-lines
         str/replace str/replace-first str/reverse str/index-of str/last-index-of
         ;; Regex
         re-find re-seq re-matches re-pattern re-matcher re-groups
         str/re-quote-replacement
         ;; Letters
         str/capitalize str/lower-case str/upper-case
         ;; Trim
         str/trim str/trim-newline str/triml str/trimr
         ;; Test
         string? str/blank? str/starts-with? str/ends-with? str/includes?)))

(spec/def :h/collection-operation
  (set '(;; General
         count empty not-empty into conj walk/walk walk/prewalk walk/prewalk-demo
         walk/prewalk-replace walk/postwalk walk/postwalk-demo
         walk/postwalk-replace bounded-count
         ;; Content Tets
         distinct? empty? every? not-every? some not-any?
         ;; Capabilities
         sequential? associative? sorted? counted? reversible?
         ;; Type Tests
         coll? list? vector? set? map? seq? record? map-entry?)))

(spec/def :h/list-operation
  (set '(;; Create
         list list*
         ;; Examine
         first nth peek .indexOf .lastIndexOf
         ;; Change
         cons conj rest pop)))

(spec/def :h/legal-symbol (set/union (map s/form [:h/numeric-operation
                                                  :h/sequence-operation
                                                  :h/string-operation
                                                  :h/collection-operation
                                                  :h/list-operation])))

(spec/def :h/matches (spec/coll-of :h/match))

(spec/def :h/responses (spec/coll-of :h/response))

(spec/def :h/trigger (spec/keys :req [:h/matches :h/name :h/responses]))

(spec/def :h/event-map (spec/map-of :h/event-type (spec/coll-of :h/trigger)))
