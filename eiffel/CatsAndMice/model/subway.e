note
	description: "Summary description for {SUBWAY}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"
class
	SUBWAY
inherit
	LAYER
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
	make (a_id: INTEGER; a_entrance1: COORDINATE; a_entrance2: COORDINATE)
	do
		id := a_id
		entrance1 := a_entrance1
		entrance2 := a_entrance2
	end
feature {NONE}
	id : INTEGER
	--entrances: LINKED_LIST[COORDINATE]
	entrance1 : COORDINATE
	entrance2 : COORDINATE
	cats : detachable LINKED_LIST[COORDINATE]
		note
			option: stable
		attribute
		end
feature
	get_id: INTEGER
	do
		Result := id
	end
	--get_entrances: LINKED_LIST[COORDINATE]
	get_entrance1: COORDINATE
	do
		Result:= entrance1
	end
	get_entrance2: COORDINATE
	do
		Result:= entrance2
	end
	--get_entrances: LINKED_LIST[COORDINATE]
	get_cats: detachable LINKED_LIST [COORDINATE]
	do
		Result:= cats
	end
	is_surface: BOOLEAN
	do
		Result:= FALSE
	end
feature
	update_cats (a_cats: LINKED_LIST [CAT])
	local
		b_cats: LINKED_LIST [COORDINATE]
	do
		create b_cats.make
		across a_cats as cat loop
			b_cats.extend(cat.item.get_position.get_coordinate)
		end
		cats := b_cats
	end
	--set_entrances (ents: LINKED_LIST[COORDINATE])
	set_entrances(ent1: COORDINATE; ent2: COORDINATE)
	do
		entrance1 := ent1
		entrance2 := ent2
	end
feature
	out: STRING
	do
		Result := id.out + "; e1: " + entrance1.out + "; e2: " + entrance2.out
	end
end
