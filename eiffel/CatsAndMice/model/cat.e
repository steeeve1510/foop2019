note
	description: "Summary description for {CAT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CAT
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
	make(init: POSITION; a_client:CLIENT)
	do
		position := init
		client := a_client
		client.set_player(current)
		last_action := -1
	end
feature
	set_position(a_position: POSITION)
	do
		position := a_position
	end
	--update
	--do

	--end
	make_move(game: GAME)
	local
		command : COMMAND
	do
		command := client.get_next_move(game)
		if command /= void then
			command.execute(current, game)
		end
		--client.get_next_move(game)
	end
	set_last_action(a_last_action: INTEGER)
	do
		last_action := a_last_action
	end
	win
	do
		won := True
	end
feature
	get_position: POSITION
	do
		Result := position
	end
	is_dead: BOOLEAN
	do
		Result := false
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
	do
		Result := "Cat at " + position.out
	end
feature
	position : POSITION assign set_position
	client: CLIENT
	last_action: INTEGER assign set_last_action
	won: BOOLEAN
end
