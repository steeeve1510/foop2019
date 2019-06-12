note
	description: "Summary description for {BOT_UTIL}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	BOT_UTIL
feature
	get_nearest(c1: COORDINATE; others: LINKED_LIST[COORDINATE]): COORDINATE
	local
		coord: COORDINATE
		minimum: INTEGER
	do
		create coord.make(0,0)
		minimum := 100
		across others as ic loop
			if get_distance(c1, ic.item) <= minimum then
				coord := ic.item
			end
		end
		Result := coord
	ensure
		instance_free: class
	end

	get_distance(c1: COORDINATE; c2: COORDINATE): INTEGER
	do
		Result := ( {SINGLE_MATH}.rabs(c1.get_x - c2.get_x) + {SINGLE_MATH}.rabs(c1.get_y - c2.get_y)).floor
	ensure
		instance_free: class
		positive_distance: Result >= 0
	end

	get_nearest_exit(sub: SUBWAY; goal: SUBWAY): COORDINATE
	local
		goals: LINKED_LIST [COORDINATE]
		exit1, exit2: COORDINATE
	do
		create goals.make
		goals.extend(goal.get_entrance1)
		goals.extend(goal.get_entrance2)
		exit1 := get_nearest(sub.get_entrance1, goals)
		exit2 := get_nearest(sub.get_entrance2, goals)
		if get_distance(exit1, sub.get_entrance1) > get_distance(exit2, sub.get_entrance2) then
			Result := sub.get_entrance2
		else
			Result := sub.get_entrance1
		end
	ensure
		instance_free: class
	end
end
