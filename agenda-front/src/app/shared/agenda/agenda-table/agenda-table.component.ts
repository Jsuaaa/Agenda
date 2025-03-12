import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agenda-table',
  imports: [],
  templateUrl: './agenda-table.component.html',
  styleUrl: './agenda-table.component.css'
})
export class AgendaTableComponent implements OnInit{

  // Variable para guardar todos los elementos de la agenda
  agenda:Object = {
    lunes: {},
    martes: {},
    miercoles: {},
    jueves: {},
    viernes: {},
    sabado: {},
    domingo: {},
  }


  ngOnInit(): void {
    
  }



}
