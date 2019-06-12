class
    COORDINATE
inherit
    ANY
        redefine
            out, is_equal
        end
create
    make

feature
    make (a_x, a_y: INTEGER)
        do
            set_x (a_x)
            set_y (a_y)
        ensure
            x_set: x = a_x
            y_set: y = a_y
        end
feature {NONE}
    x: INTEGER assign set_x
    y: INTEGER assign set_y
feature
    set_x (a_x: INTEGER)
        do
            x := a_x
        ensure
            x_set: x = a_x
            positive_x: x >= 0
        end
    set_y (a_y: INTEGER)
        do
            y := a_y
        ensure
            y_set: y = a_y
            positive_y: y >= 0
        end
feature
	get_x: INTEGER
	do
		Result := x
	end
	get_y: INTEGER
	do
		Result := y
	end
feature
    out: STRING
        do
            Result := "{" + x.out + "," + y.out +"}"
        end
feature
    is_equal(other: COORDINATE): BOOLEAN
        do
            Result := (x = other.get_x) and (y = other.get_y)
        end
end
