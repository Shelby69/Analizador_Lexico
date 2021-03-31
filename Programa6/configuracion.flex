package fes.aragon.codigo;
%%
%public
%class AnalizadorLexico
%line
%column
%char
%full
%type Token
%{
    private boolean hayToken=false;
    public boolean getHayToken(){
        return this.hayToken;
    }
%}
%init{
    /*codig que se ejecuta en el constructor de la clase*/
%init}
%eof{
    /*codigo que se ejecuta al terminar el archivo*/
    this.hayToken=false;
%eof}
Espacio=" "
PuntoComa=";"
saltoLinea=\n|\r
ENTERO=[0-9]+
ID=[a-zA-ZñÑ][_0-9A-Za-zñÑ]*
%%
{ENTERO} {
        Token token=new Token(yytext(),Sym.ENTERO,yyline+1,yycolumn+1);
        this.hayToken=true;
        return token;
}

{ID} {
        Token token=new Token(yytext(),Sym.ID,yyline+1,yycolumn+1);
        this.hayToken=true;
        return token;
}

{PuntoComa} {
        Token token=new Token(yytext(),Sym.PUNTOCOMA,yyline+1,yycolumn+1);
        this.hayToken=true;
        return token;
}
{saltoLinea} {
}
{Espacio} {
}
. {
    String error="Error Lexico: " +yytext() + "linea "+
    (yyline+1)+ "columna " + (yycolumn+1);
    System.out.println(error);
}

