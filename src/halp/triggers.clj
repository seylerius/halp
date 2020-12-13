(ns halp.triggers
  (:require [clojure.spec.alpha :as s]))

(def event-intents
  {:guild-create                  [:guilds]
   :guild-update                  [:guilds]
   :guild-delete                  [:guilds]
   :guild-role-create             [:guilds]
   :guild-role-update             [:guilds]
   :guild-role-delete             [:guilds]
   :channel-create                [:guilds]
   :channel-update                [:guilds]
   :channel-delete                [:guilds]
   :channel-pins-update           [:guilds]
   :guild-member-add              [:guild-members]
   :guild-member-update           [:guild-members]
   :guild-member-remove           [:guild-members]
   :guild-ban-add                 [:guild-bans]
   :guild-ban-remove              [:guild-bans]
   :guild-emojis-update           [:guild-emojis]
   :guild-integrations-update     [:guild-integrations]
   :webhooks-update               [:guild-webhooks]
   :invite-create                 [:guild-invites]
   :invite-delete                 [:guild-invites]
   :voice-state-update            [:guild-voice-states]
   :presence-update               [:guild-presences]
   :message-create                [:guild-messages :direct-messages]
   :message-update                [:guild-messages :direct-messages]
   :message-delete                [:guild-messages :direct-messages]
   :message-delete-bulk           [:guild-messages]
   :message-reaction-add          [:guild-message-reactions
                                   :direct-message-reactions]
   :message-reaction-remove       [:guild-message-reactions
                                   :direct-message-reactions]
   :message-reaction-remove-all   [:guild-message-reactions
                                   :direct-message-reactions]
   :message-reaction-remove-emoji [:guild-message-reactions
                                   :direct-message-reactions]
   :typing-start                  [:guild-message-typing
                                   :direct-message-typing]})
