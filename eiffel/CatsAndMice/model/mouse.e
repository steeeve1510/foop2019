note
	description: "Summary description for {MOUSE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOUSE
inherit
	PLAYER
		redefine
            out
    	end
	ANY
        redefine
            out
        end
create
	make
feature
	make(a_position: POSITION; a_client:CLIENT)
	do
		dead := false
		won := false
		position := a_position
		client := a_client
		client.set_player(current)
		last_action := -2
	end
feature
	set_position(a_position: POSITION)
	do
		position := a_position
	end
	--
	kill
	do
		dead := True
	end
	win
	do
		won := True
	end
	----
	make_move(game: GAME)
	local
		command: COMMAND
	do
		if (not dead) and (not (position.get_layer = game.get_goal_subway)) and ((game.get_frame - last_action)>1) then
			--client.get_next_move(game)
			command := client.get_next_move(game)
			if command /= void then
				command.execute(current, game)
				set_last_action(game.get_frame)
			--else
				--print ("Do nothing %N")
			end
		end
	end
	--
	set_last_action(a_last_action: INTEGER)
	do
		last_action := a_last_action
	end
feature
	get_position: POSITION
	do
		Result := position
	end
	is_dead: BOOLEAN
	do
		Result := dead
	end
	is_on_surface: BOOLEAN
	do
		Result := position.is_on_surface
	end
	get_last_action: INTEGER
	do
		Result := last_action
	end
	has_won: BOOLEAN
	do
		Result := won
	end
	out: STRING
	local
		state: STRING
	do
		create state.make_empty
		if attached {MOUSE_USER_CLIENT} client then
			state := "Player "
		end
		if dead then
			state := state +"Mouse Dead"
		elseif won then
			state := state +"Mouse Won"
		else
			state := state + "Mouse at " + position.out
		end
		Result := state
	end
feature {NONE}
	position : POSITION assign set_position
	dead : BOOLEAN
	client: CLIENT
	last_action: INTEGER assign set_last_action
	won: BOOLEAN
end
