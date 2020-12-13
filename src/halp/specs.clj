(ns halp.specs
  (:require [clojure.spec.alpha :as s]))

(s/def ::name string?)

(s/def ::event-type
  #{:guild-create :guild-update :guild-delete :guild-role-create
    :guild-role-update :guild-role-delete :channel-create :channel-update
    :channel-delete :channel-pins-update :guild-member-:guild-member-update
    :guild-member-remove :guild-ban-add :guild-ban-remove :guild-emojis-update
    :guild-integrations-update :webhooks-update :invite-create :invite-delete
    :voice-state-update :presence-update :message-create :message-update
    :message-delete :message-delete-bulk :message-reaction-add
    :message-reaction-remove :message-reaction-remove-all
    :message-reaction-remove-emoji :channel-pins-update :typing-start})

(s/def ::matches (s/coll-of ::match))

(s/def ::responses (s/coll-of ::response))

(s/def ::trigger (s/keys :req [::matches ::name ::responses]))

(s/def ::event-map (s/map-of ::event-type (s/coll-of ::trigger)))
