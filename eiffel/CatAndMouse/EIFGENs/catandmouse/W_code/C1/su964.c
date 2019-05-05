/*
 * Code for class SUBWAY
 */

#include "eif_eiffel.h"
#include "../E1/estructure.h"


#ifdef __cplusplus
extern "C" {
#endif

extern EIF_TYPED_VALUE F964_7200(EIF_REFERENCE);
extern EIF_TYPED_VALUE F964_7201(EIF_REFERENCE);
extern EIF_TYPED_VALUE F964_7202(EIF_REFERENCE);
extern void F964_7203(EIF_REFERENCE, EIF_TYPED_VALUE, EIF_TYPED_VALUE);
extern EIF_TYPED_VALUE F964_7204(EIF_REFERENCE, EIF_TYPED_VALUE);
extern void EIF_Minit964(void);

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

/* {SUBWAY}.id */
EIF_TYPED_VALUE F964_7200 (EIF_REFERENCE Current)
{
	EIF_TYPED_VALUE r;
	r.type = SK_INT32;
	r.it_i4 = *(EIF_INTEGER_32 *)(Current + RTWA(4989,Dtype(Current)));
	return r;
}


/* {SUBWAY}.entrances */
EIF_TYPED_VALUE F964_7201 (EIF_REFERENCE Current)
{
	EIF_TYPED_VALUE r;
	r.type = SK_REF;
	r.it_r = *(EIF_REFERENCE *)(Current + RTWA(4990,Dtype(Current)));
	return r;
}


/* {SUBWAY}.catslastseen */
EIF_TYPED_VALUE F964_7202 (EIF_REFERENCE Current)
{
	EIF_TYPED_VALUE r;
	r.type = SK_REF;
	r.it_r = *(EIF_REFERENCE *)(Current + RTWA(4991,Dtype(Current)));
	return r;
}


/* {SUBWAY}.makesubway */
void F964_7203 (EIF_REFERENCE Current, EIF_TYPED_VALUE arg1x, EIF_TYPED_VALUE arg2x)
{
	GTCX
	char *l_feature_name = "makesubway";
	RTEX;
#define arg1 arg1x.it_r
#define arg2 arg2x.it_r
	EIF_REFERENCE tr1 = NULL;
	EIF_INTEGER_32 ti4_1;
	RTCDT;
	RTSN;
	RTDA;
	RTLD;
	
	
	RTLI(4);
	RTLR(0,arg1);
	RTLR(1,arg2);
	RTLR(2,Current);
	RTLR(3,tr1);
	RTLIU(4);
	RTLU (SK_VOID, NULL);
	RTLU(SK_REF,&arg1);
	RTLU(SK_REF,&arg2);
	RTLU (SK_REF, &Current);
	
	RTEAA(l_feature_name, 963, Current, 0, 2, 13488);
	RTSA(dtype);
	RTSC;
	RTME(dtype, 0);
	RTGC;
	RTDBGEAA(963, Current, 13488);
	RTCC(arg1, 963, l_feature_name, 1, eif_new_type(959, 0x01), 0x01);
	{
		static EIF_TYPE_INDEX typarr0[] = {0xFF01,965,0xFF01,960,0xFFFF};
		EIF_TYPE typres0;
		static EIF_TYPE typcache0 = {INVALID_DTYPE, 0};
		
		typres0 = (typcache0.id != INVALID_DTYPE ? typcache0 : (typcache0 = eif_compound_id(Dftype(Current), typarr0)));
		RTCC(arg2, 963, l_feature_name, 2, typres0, 0x01);
	}
	RTIV(Current, RTAL);
	RTHOOK(1);
	RTDBGAA(Current, dtype, 4989, 0x10000000, 1); /* id */
	ti4_1 = (((FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE)) RTVF(4982, "newsubway", arg1))(arg1)).it_i4);
	*(EIF_INTEGER_32 *)(Current + RTWA(4989, dtype)) = (EIF_INTEGER_32) ti4_1;
	RTHOOK(2);
	RTDBGAA(Current, dtype, 4990, 0xF80003C5, 0); /* entrances */
	tr1 = RTCCL(arg2);
	RTAR(Current, tr1);
	*(EIF_REFERENCE *)(Current + RTWA(4990, dtype)) = (EIF_REFERENCE) tr1;
	RTHOOK(3);
	RTDBGAA(Current, dtype, 4991, 0xF80003C5, 0); /* catslastseen */
	tr1 = RTLNSMART(RTWCT(4991, dtype, Dftype(Current)).id);
	(FUNCTION_CAST(void, (EIF_REFERENCE)) RTWC(2764, Dtype(tr1)))(tr1);
	RTNHOOK(3,1);
	tr1 = RTCCL(tr1);
	RTAR(Current, tr1);
	*(EIF_REFERENCE *)(Current + RTWA(4991, dtype)) = (EIF_REFERENCE) tr1;
	RTVI(Current, RTAL);
	RTRS;
	RTHOOK(4);
	RTDBGLE;
	RTMD(0);
	RTLE;
	RTLO(4);
	RTEE;
#undef arg2
#undef arg1
}

/* {SUBWAY}.equals */
EIF_TYPED_VALUE F964_7204 (EIF_REFERENCE Current, EIF_TYPED_VALUE arg1x)
{
	GTCX
	char *l_feature_name = "equals";
	RTEX;
#define arg1 arg1x.it_r
	EIF_TYPED_VALUE up1x = {{0}, SK_POINTER};
#define up1 up1x.it_p
	EIF_TYPED_VALUE ur1x = {{0}, SK_REF};
#define ur1 ur1x.it_r
	EIF_REFERENCE tr1 = NULL;
	EIF_REFERENCE tr2 = NULL;
	EIF_BOOLEAN Result = ((EIF_BOOLEAN) 0);
	
	RTSN;
	RTDA;
	RTLD;
	
	
	RTLI(5);
	RTLR(0,arg1);
	RTLR(1,tr1);
	RTLR(2,ur1);
	RTLR(3,tr2);
	RTLR(4,Current);
	RTLIU(5);
	RTLU (SK_BOOL, &Result);
	RTLU(SK_REF,&arg1);
	RTLU (SK_REF, &Current);
	
	RTEAA(l_feature_name, 963, Current, 0, 1, 13489);
	RTSA(Dtype(Current));
	RTSC;
	RTME(Dtype(Current), 0);
	RTGC;
	RTDBGEAA(963, Current, 13489);
	RTCC(arg1, 963, l_feature_name, 1, eif_new_type(961, 0x01), 0x01);
	RTIV(Current, RTAL);
	RTHOOK(1);
	tr1 = RTLNTY2(eif_new_type(963, 0x01), 0x01);
	ur1 = RTCCL(arg1);
	tr2 = ((up1x = (FUNCTION_CAST(EIF_TYPED_VALUE, (EIF_REFERENCE, EIF_TYPED_VALUE)) RTVF(3878, "attempted", tr1))(tr1, ur1x)), (((up1x.type & SK_HEAD) == SK_REF)? (EIF_REFERENCE) 0: (up1x.it_r = RTBU(up1x))), (up1x.type = SK_POINTER), up1x.it_r);
	if ((EIF_BOOLEAN)(tr2 != NULL)) {
		RTHOOK(2);
		RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
		Result = (EIF_BOOLEAN) (EIF_BOOLEAN) 1;
	} else {
		RTHOOK(3);
		RTDBGAL(Current, 0, 0x04000000, 1,0); /* Result */
		Result = (EIF_BOOLEAN) (EIF_BOOLEAN) 0;
	}
	RTVI(Current, RTAL);
	RTRS;
	RTHOOK(4);
	RTDBGLE;
	RTMD(0);
	RTLE;
	RTLO(3);
	RTEE;
	{ EIF_TYPED_VALUE r; r.type = SK_BOOL; r.it_b = Result; return r; }
#undef up1
#undef ur1
#undef arg1
}

void EIF_Minit964 (void)
{
	GTCX
}


#ifdef __cplusplus
}
#endif
