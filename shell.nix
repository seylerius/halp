{ pkgs ? import <nixpkgs> { } }:

pkgs.mkShell {
  buildInputs = with pkgs; [ clojure leiningen ];

  lorriHook = ''
    export DISCORD_AUTH_TOKEN=$(pass show Halp/DiscordAuthToken)
  '';
}
