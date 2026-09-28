export class Candidato {
    constructor(public nome:string,public cpf:string,public idade:number,
                public pais:string,public cep:string,public descricao:string,
                public competencias:string[],public formacao: string)
    {}
}