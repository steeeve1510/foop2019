/*
 * Code for class SUBSET_STRATEGY_HASHABLE [G#1]
 */

#include "eif_eiffel.h"
#include "../E1/estructure.h"


#ifdef __cplusplus
extern "C" {
#endif

extern EIF_TYPED_VALUE F972_1927(EIF_REFERENCE, EIF_TYPED_VALUE, EIF_TYPED_VALUE);
extern void F972_1928(EIF_REFERENCE, EIF_TYPED_VALUE, EIF_TYPED_VALUE);
extern void EIF_Minit972(void);

#ifdef __cplusplus
}
#endif


#ifdef __cplusplus
extern "C" {
#endif


#ifdef __cplusplus
}
#endif


#ifdef __cplusplus
extern "C" {
#endif

/* {SUBSET_STRATEGY_HASHABLE}.disjoint */
EIF_TYPED_VALUE F972_1927 (EIF_REFERENCE Current, EIF_TYPED_VALUE arg1x, EIF_TYPED_VALUE arg2x)
{
	GTCX
	char *l_feature_name = "disjoint";
	RTEX;
	EIF_REFERENCE loc1 = (EIF_REFERENCE) 0;
	EIF_INTEGER_32 loc2 = (EIF_INTEGER_32) 0;
	EIF_REFERENCE loc3 = (EIF_REFERENCE) 0;
	EIF_REFERENCE loc4 = (EIF_REFERENCE) 0;
#define arg1 arg1x.it_r
#define arg2 arg2x.it_r
	EIF_TYPED_VALUE up1x = {{0}, SK_POINTER};
#define up1 up1x.it_p
	EIF_TYPED_VALUE ur1x = {{0}, SK_REF};
#define ur1 ur1x.it_r
	EIF_TYPED_VALUE ui4_1x = {{0}, SK_INT32};
#define ui4_1 ui4_1x.it_i4
	EIF_REFERENCE tr1 = NULL;
	EIF_REFERENCE tr2 = NULL;
	EIF_INTEGER_32 ti4_1;
	EIF_INTEGER_32 ti4_2;
	EIF_BOOLEAN tb1;
	EIF_BOOLEAN tb2;
	EIF_BOOLEAN tb3;
	EIF_BOOLEAN Result = ((EIF_BOOLEAN) 0);
	
	RTCDT;
	RTSN;
	RTDA;
	RTLD;
	
	
	RTLI(9);
	RTLR(0,arg1);
	RTLR(1,arg2);
	RTLR(2,loc1);
	RTLR(3,Current);
	RTLR(4,tr1);
	RTLR(5,loc3);
	RTLR(6,ur1);
	RTLR(7,tr2);
	RTLR(8,loc4);
	RTLIU(9);
	RTLU (SK_BOOL, &Result);
	RTLU(SK_REF,&arg1);
	RTLU(SK_REF,&arg2);
	RTLU (SK_REF, &Current);
	RTLU(SK_REF, &loc1);
	RTLU(SK_INT32, &loc2);
	RTLU(SK_REF, &loc3);
	RTLU(SK_REF, &loc4);
	
	RTEAA(l_feature_name, 971, Current, 4, 2, 13490);
	RTSA(dtype);
	RTSC;
	RTME(dtype, 0);
	RTGC;
	RTDBGEAA(971, Current, 13490);
	{
		EIF_TYPE_INDEX typarr0[] = {0xFF01,966,0,0,0xFFFF};
		EIF_TYPE typres0;
		{
			EIF_TYPE l_type;
			l_type = RTWCT(1717, dtype, Dftype(Current));
			typarr0[2] = l_type.annotations | 0xFF00;
			typarr0[3] = l_type.id;
		}
		
		typres0 = eif_compound_id(Dftype(Current), typarr0);
		RTCC(arg1, 971, l_feature_name, 1, typres0, 0x01);
	}
	{
		EIF_TYPE_INDEX typarr0[] = {0xFF01,966,0,0,0xFFFF};
		EIF_TYPE typres0;
		{
			EIF_TYPE l_type;
			l_type = RTWCT(1717, dtype, Dftype(Current));
			typarr0[2] = l_type.annotations | 0xFF00;
			typarr0[3] = l_type.id;
		}
		
		typres0 = eif_compound_id(Dftype(Current), typarr0);
		RTCC(arg2, 971, l_feature_name, 2, typres0, 0x01);
	}
	RTIV(Current, RTAL);
	if ((RTAL & CK_REQUIRE) || RTAC) {
		RTHOOK(1);
		RTCT("sets_exist", EX_PRE);
		RTTE((EIF_BOOLEAN) ((EIF_BOOLEAN)(arg1 != NULL) && (EIF_BOOLEAN)(arg2 != NULL)), label_1);
		RTCK;
		RTHOOK(2);
		RTCT("same_rule", EX_PRE);
		tb1 = *(EIF_BOOLEAN *)(arg1 + RTVA(2212, "object_comparison", arg1));
		tb2 = *(EIF_BOOLEAN *)(arg2 + RTVA(2212, "object_comparison", arg2));
		RTTE((EIF_BOOLEAN)(tb1 == tb2), label_1);
		RTCK;
		RTJB;
label_1:
		RTCF;
	}
body:;
	RTHOOK(3);
	RTDBGAL(Current, 1, 0xF8000217, 0, 0); /* loc1 */
	{
		EIF_TYPE_INDEX typarr0[] = {0xFF01,535,0,0,218,0xFFFF};
		EIF_TYPE typres0;
		{
			EIF_TYPE l_type;
			l_type = RTWCT(1717, dtype, Dftype(Current));
			typarr0[2] = l_type.annotations | 0xFF00;
			typarr0[3] = l_type.id;
		}
		
		typres0 = eif_compound_id(Dftype(Current), typarr0);
		tr1 = RTLN(typres0.id);
	}
	ti4_1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2227, "count", arg1))(arg1)).it_i4);
	ti4_2 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2227, "count", arg2))(arg2)).it_i4);
	ui4_1 = (EIF_INTEGER_32) (ti4_1 + ti4_2);
	(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTWC(2969, Dtype(tr1)))(tr1, ui4_1x);
	RTNHOOK(3,1);
	loc1 = (EIF_REFERENCE) RTCCL(tr1);
	RTHOOK(4);
	tb1 = *(EIF_BOOLEAN *)(arg1 + RTVA(2212, "object_comparison", arg1));
	if (tb1) {
		RTHOOK(5);
		(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2214, "compare_objects", loc1))(loc1);
	}
	RTHOOK(6);
	RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
	Result = (EIF_BOOLEAN) (EIF_BOOLEAN) 1;
	RTHOOK(7);
	(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2239, "start", arg1))(arg1);
	RTHOOK(8);
	(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2239, "start", arg2))(arg2);
	for (;;) {
		RTHOOK(9);
		tb1 = '\01';
		if (!(EIF_BOOLEAN) !Result) {
			tb2 = '\0';
			tb3 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2237, "after", arg1))(arg1)).it_b);
			if (tb3) {
				tb3 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2237, "after", arg2))(arg2)).it_b);
				tb2 = tb3;
			}
			tb1 = tb2;
		}
		if (tb1) break;
		RTHOOK(10);
		tb2 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2237, "after", arg1))(arg1)).it_b);
		if ((EIF_BOOLEAN) !tb2) {
			RTHOOK(11);
			tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg1))(arg1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
			loc3 = RTCCL(tr1);
			loc3 = RTRV(eif_new_type(184, 0x01),loc3);
			if (EIF_TEST(loc3)) {
				RTHOOK(12);
				RTDBGAL(Current, 2, 0x10000000, 1, 0); /* loc2 */
				ti4_1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(3810, "hash_code", loc3))(loc3)).it_i4);
				loc2 = (EIF_INTEGER_32) ti4_1;
			} else {
				if (RTAL & CK_CHECK) {
					RTHOOK(13);
					RTCT("hashable_item", EX_CHECK);
						RTCF;
				}
			}
			RTHOOK(14);
			RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
			ui4_1 = loc2;
			tb2 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTVF(2254, "has", loc1))(loc1, ui4_1x)).it_b);
			Result = (EIF_BOOLEAN) (EIF_BOOLEAN) !tb2;
			RTHOOK(15);
			if (Result) {
				RTHOOK(16);
				tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg1))(arg1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
				ur1 = RTCCL(tr1);
				ui4_1 = loc2;
				(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE, EIF_TYPED_VALUE)) RTVF(2255, "put", loc1))(loc1, ur1x, ui4_1x);
			} else {
				RTHOOK(17);
				ui4_1 = loc2;
				(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTVF(2997, "search", loc1))(loc1, ui4_1x);
				if (RTAL & CK_CHECK) {
					RTHOOK(18);
					RTCT("item_found", EX_CHECK);
					tb2 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2988, "found", loc1))(loc1)).it_b);
					if (tb2) {
						RTCK;
					} else {
						RTCF;
					}
				}
				RTHOOK(19);
				tb2 = *(EIF_BOOLEAN *)(arg1 + RTVA(2212, "object_comparison", arg1));
				if (tb2) {
					RTHOOK(20);
					RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
					tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg1))(arg1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					tr2 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2972, "found_item", loc1))(loc1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					Result = (EIF_BOOLEAN) !RTEQ(tr1, tr2);
				} else {
					RTHOOK(21);
					RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
					tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg1))(arg1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					tr2 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2972, "found_item", loc1))(loc1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					Result = (EIF_BOOLEAN) !RTCEQ(tr1, tr2);
				}
			}
			RTHOOK(22);
			(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2240, "forth", arg1))(arg1);
		}
		RTHOOK(23);
		tb2 = '\0';
		if (Result) {
			tb3 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2237, "after", arg2))(arg2)).it_b);
			tb2 = (EIF_BOOLEAN) !tb3;
		}
		if (tb2) {
			RTHOOK(24);
			tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
			loc4 = RTCCL(tr1);
			loc4 = RTRV(eif_new_type(184, 0x01),loc4);
			if (EIF_TEST(loc4)) {
				RTHOOK(25);
				RTDBGAL(Current, 2, 0x10000000, 1, 0); /* loc2 */
				ti4_1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(3810, "hash_code", loc4))(loc4)).it_i4);
				loc2 = (EIF_INTEGER_32) ti4_1;
			} else {
				if (RTAL & CK_CHECK) {
					RTHOOK(26);
					RTCT("hashable_item", EX_CHECK);
						RTCF;
				}
			}
			RTHOOK(27);
			ui4_1 = loc2;
			(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTVF(2997, "search", loc1))(loc1, ui4_1x);
			RTHOOK(28);
			RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
			tb2 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2988, "found", loc1))(loc1)).it_b);
			Result = (EIF_BOOLEAN) (EIF_BOOLEAN) !tb2;
			RTHOOK(29);
			if (Result) {
				RTHOOK(30);
				tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
				ur1 = RTCCL(tr1);
				ui4_1 = loc2;
				(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE, EIF_TYPED_VALUE)) RTVF(2255, "put", loc1))(loc1, ur1x, ui4_1x);
			} else {
				RTHOOK(31);
				tb2 = *(EIF_BOOLEAN *)(arg1 + RTVA(2212, "object_comparison", arg1));
				if (tb2) {
					RTHOOK(32);
					RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
					tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					tr2 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2972, "found_item", loc1))(loc1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					Result = (EIF_BOOLEAN) !RTEQ(tr1, tr2);
				} else {
					RTHOOK(33);
					RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
					tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					tr2 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2972, "found_item", loc1))(loc1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					Result = (EIF_BOOLEAN) !RTCEQ(tr1, tr2);
				}
			}
			RTHOOK(34);
			(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2240, "forth", arg2))(arg2);
		}
	}
	RTVI(Current, RTAL);
	RTRS;
	RTHOOK(35);
	RTDBGLE;
	RTMD(0);
	RTLE;
	RTLO(8);
	RTEE;
	{ EIF_TYPED_VALUE r; r.type = SK_BOOL; r.it_b = Result; return r; }
#undef up1
#undef ur1
#undef ui4_1
#undef arg2
#undef arg1
}

/* {SUBSET_STRATEGY_HASHABLE}.symdif */
void F972_1928 (EIF_REFERENCE Current, EIF_TYPED_VALUE arg1x, EIF_TYPED_VALUE arg2x)
{
	GTCX
	char *l_feature_name = "symdif";
	RTEX;
	EIF_REFERENCE loc1 = (EIF_REFERENCE) 0;
	EIF_INTEGER_32 loc2 = (EIF_INTEGER_32) 0;
	EIF_BOOLEAN loc3 = (EIF_BOOLEAN) 0;
	EIF_REFERENCE loc4 = (EIF_REFERENCE) 0;
	EIF_REFERENCE loc5 = (EIF_REFERENCE) 0;
	EIF_REFERENCE loc6 = (EIF_REFERENCE) 0;
#define arg1 arg1x.it_r
#define arg2 arg2x.it_r
	EIF_TYPED_VALUE up1x = {{0}, SK_POINTER};
#define up1 up1x.it_p
	EIF_TYPED_VALUE ur1x = {{0}, SK_REF};
#define ur1 ur1x.it_r
	EIF_TYPED_VALUE ui4_1x = {{0}, SK_INT32};
#define ui4_1 ui4_1x.it_i4
	EIF_REFERENCE tr1 = NULL;
	EIF_REFERENCE tr2 = NULL;
	EIF_INTEGER_32 ti4_1;
	EIF_INTEGER_32 ti4_2;
	EIF_BOOLEAN tb1;
	EIF_BOOLEAN tb2;
	EIF_BOOLEAN tb3;
	RTCDT;
	RTSN;
	RTDA;
	RTLD;
	
	
	RTLI(10);
	RTLR(0,arg1);
	RTLR(1,arg2);
	RTLR(2,loc1);
	RTLR(3,Current);
	RTLR(4,tr1);
	RTLR(5,loc5);
	RTLR(6,ur1);
	RTLR(7,loc6);
	RTLR(8,tr2);
	RTLR(9,loc4);
	RTLIU(10);
	RTLU (SK_VOID, NULL);
	RTLU(SK_REF,&arg1);
	RTLU(SK_REF,&arg2);
	RTLU (SK_REF, &Current);
	RTLU(SK_REF, &loc1);
	RTLU(SK_INT32, &loc2);
	RTLU(SK_BOOL, &loc3);
	RTLU(SK_REF, &loc4);
	RTLU(SK_REF, &loc5);
	RTLU(SK_REF, &loc6);
	
	RTEAA(l_feature_name, 971, Current, 6, 2, 13491);
	RTSA(dtype);
	RTSC;
	RTME(dtype, 0);
	RTGC;
	RTDBGEAA(971, Current, 13491);
	{
		EIF_TYPE_INDEX typarr0[] = {0xFF01,966,0,0,0xFFFF};
		EIF_TYPE typres0;
		{
			EIF_TYPE l_type;
			l_type = RTWCT(1717, dtype, Dftype(Current));
			typarr0[2] = l_type.annotations | 0xFF00;
			typarr0[3] = l_type.id;
		}
		
		typres0 = eif_compound_id(Dftype(Current), typarr0);
		RTCC(arg1, 971, l_feature_name, 1, typres0, 0x01);
	}
	{
		EIF_TYPE_INDEX typarr0[] = {0xFF01,966,0,0,0xFFFF};
		EIF_TYPE typres0;
		{
			EIF_TYPE l_type;
			l_type = RTWCT(1717, dtype, Dftype(Current));
			typarr0[2] = l_type.annotations | 0xFF00;
			typarr0[3] = l_type.id;
		}
		
		typres0 = eif_compound_id(Dftype(Current), typarr0);
		RTCC(arg2, 971, l_feature_name, 2, typres0, 0x01);
	}
	RTIV(Current, RTAL);
	if ((RTAL & CK_REQUIRE) || RTAC) {
		RTHOOK(1);
		RTCT("sets_exist", EX_PRE);
		RTTE((EIF_BOOLEAN) ((EIF_BOOLEAN)(arg1 != NULL) && (EIF_BOOLEAN)(arg2 != NULL)), label_1);
		RTCK;
		RTHOOK(2);
		RTCT("same_rule", EX_PRE);
		tb1 = *(EIF_BOOLEAN *)(arg1 + RTVA(2212, "object_comparison", arg1));
		tb2 = *(EIF_BOOLEAN *)(arg2 + RTVA(2212, "object_comparison", arg2));
		RTTE((EIF_BOOLEAN)(tb1 == tb2), label_1);
		RTCK;
		RTJB;
label_1:
		RTCF;
	}
body:;
	RTHOOK(3);
	RTDBGAL(Current, 1, 0xF8000217, 0, 0); /* loc1 */
	{
		EIF_TYPE_INDEX typarr0[] = {0xFF01,535,0,0,218,0xFFFF};
		EIF_TYPE typres0;
		{
			EIF_TYPE l_type;
			l_type = RTWCT(1717, dtype, Dftype(Current));
			typarr0[2] = l_type.annotations | 0xFF00;
			typarr0[3] = l_type.id;
		}
		
		typres0 = eif_compound_id(Dftype(Current), typarr0);
		tr1 = RTLN(typres0.id);
	}
	ti4_1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2227, "count", arg1))(arg1)).it_i4);
	ti4_2 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2227, "count", arg2))(arg2)).it_i4);
	ui4_1 = (EIF_INTEGER_32) (ti4_1 + ti4_2);
	(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTWC(2969, Dtype(tr1)))(tr1, ui4_1x);
	RTNHOOK(3,1);
	loc1 = (EIF_REFERENCE) RTCCL(tr1);
	RTHOOK(4);
	tb1 = *(EIF_BOOLEAN *)(arg1 + RTVA(2212, "object_comparison", arg1));
	if (tb1) {
		RTHOOK(5);
		(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2214, "compare_objects", loc1))(loc1);
	}
	RTHOOK(6);
	(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2239, "start", arg1))(arg1);
	for (;;) {
		RTHOOK(7);
		tb1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2237, "after", arg1))(arg1)).it_b);
		if (tb1) break;
		RTHOOK(8);
		tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg1))(arg1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
		loc5 = RTCCL(tr1);
		loc5 = RTRV(eif_new_type(184, 0x01),loc5);
		if (EIF_TEST(loc5)) {
			RTHOOK(9);
			tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg1))(arg1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
			ur1 = RTCCL(tr1);
			ti4_1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(3810, "hash_code", loc5))(loc5)).it_i4);
			ui4_1 = ti4_1;
			(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE, EIF_TYPED_VALUE)) RTVF(2255, "put", loc1))(loc1, ur1x, ui4_1x);
		} else {
			if (RTAL & CK_CHECK) {
				RTHOOK(10);
				RTCT("hashable_item", EX_CHECK);
					RTCF;
			}
		}
		RTHOOK(11);
		(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2240, "forth", arg1))(arg1);
	}
	RTHOOK(12);
	(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2239, "start", arg2))(arg2);
	for (;;) {
		RTHOOK(13);
		tb2 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2237, "after", arg2))(arg2)).it_b);
		if (tb2) break;
		RTHOOK(14);
		tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
		loc6 = RTCCL(tr1);
		loc6 = RTRV(eif_new_type(184, 0x01),loc6);
		if (EIF_TEST(loc6)) {
			RTHOOK(15);
			RTDBGAL(Current, 2, 0x10000000, 1, 0); /* loc2 */
			ti4_1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(3810, "hash_code", loc6))(loc6)).it_i4);
			loc2 = (EIF_INTEGER_32) ti4_1;
			RTHOOK(16);
			ui4_1 = loc2;
			(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTVF(2997, "search", loc1))(loc1, ui4_1x);
			RTHOOK(17);
			tb3 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2988, "found", loc1))(loc1)).it_b);
			if (tb3) {
				RTHOOK(18);
				tb3 = *(EIF_BOOLEAN *)(arg1 + RTVA(2212, "object_comparison", arg1));
				if (tb3) {
					RTHOOK(19);
					RTDBGAL(Current, 3, 0x04000000, 1, 0); /* loc3 */
					tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					tr2 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2972, "found_item", loc1))(loc1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					loc3 = (EIF_BOOLEAN) RTEQ(tr1, tr2);
				} else {
					RTHOOK(20);
					RTDBGAL(Current, 3, 0x04000000, 1, 0); /* loc3 */
					tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					tr2 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2972, "found_item", loc1))(loc1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
					loc3 = (EIF_BOOLEAN) RTCEQ(tr1, tr2);
				}
				RTHOOK(21);
				if (loc3) {
					RTHOOK(22);
					ui4_1 = loc2;
					(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTVF(3005, "remove", loc1))(loc1, ui4_1x);
				}
			} else {
				RTHOOK(23);
				tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2236, "item", arg2))(arg2)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
				ur1 = RTCCL(tr1);
				ui4_1 = loc2;
				(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE, EIF_TYPED_VALUE)) RTVF(2255, "put", loc1))(loc1, ur1x, ui4_1x);
			}
		} else {
			if (RTAL & CK_CHECK) {
				RTHOOK(24);
				RTCT("hashable_item", EX_CHECK);
					RTCF;
			}
		}
		RTHOOK(25);
		(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2240, "forth", arg2))(arg2);
	}
	RTHOOK(26);
	(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2226, "wipe_out", arg1))(arg1);
	RTHOOK(27);
	(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2994, "start", loc1))(loc1);
	for (;;) {
		RTHOOK(28);
		tb3 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2990, "after", loc1))(loc1)).it_b);
		if (tb3) break;
		RTHOOK(29);
		RTDBGAL(Current, 4, 0xF8000000, 0, 0); /* loc4 */
		tr1 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(2977, "item_for_iteration", loc1))(loc1)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
		loc4 = (EIF_REFERENCE) RTCCL(tr1);
		RTHOOK(30);
		if ((EIF_BOOLEAN)(loc4 != NULL)) {
			RTHOOK(31);
			ur1 = RTCCL(loc4);
			(FUNCTION_CAST(void, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTVF(2222, "extend", arg1))(arg1, ur1x);
		}
		RTHOOK(32);
		(FUNCTION_CAST(void, (EIF_REFERENCE)) RTVF(2995, "forth", loc1))(loc1);
	}
	RTVI(Current, RTAL);
	RTRS;
	RTHOOK(33);
	RTDBGLE;
	RTMD(0);
	RTLE;
	RTLO(10);
	RTEE;
#undef up1
#undef ur1
#undef ui4_1
#undef arg2
#undef arg1
}

void EIF_Minit972 (void)
{
	GTCX
}


#ifdef __cplusplus
}
#endif
