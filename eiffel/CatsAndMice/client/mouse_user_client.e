note
	description: "Summary description for {MOUSE_USER_CLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOUSE_USER_CLIENT

inherit
	CLIENT
feature
	get_next_move(game: GAME): detachable COMMAND
	local
		key: CHARACTER
		valid: BOOLEAN
	do
		if player /= void and then (not player.is_dead and not player.has_won) then
			from
				valid := false
			until
				valid = true
			loop
				print("WASD<.(ENTER):")
				io.read_character
				key := io.lastchar
				valid := true
				inspect key
					when 'w' then
						Result:= create {UP_COMMAND}
					when 's' then
						Result:= create {DOWN_COMMAND}
					when 'a' then
						Result:= create {LEFT_COMMAND}
					when 'd' then
						Result:= create {RIGHT_COMMAND}
					when '<' then
						Result:= create {LAYER_COMMAND}
					when '.' then
						Result:= create {LAYER_COMMAND}
					else
						valid:= false
				end
			end
		else
			Result := void
		end
	end

	read_char: CHARACTER
        -- Read a character from console.
    external "C inline use <stdio.h>"
        alias "return getchar ();"
    end
feature
	game_over
	do
	end
	set_player(m: MOUSE)
	do
		player := m
	end
feature {NONE}
	player: detachable PLAYER
		note
			option: stable
		attribute
		end
end
