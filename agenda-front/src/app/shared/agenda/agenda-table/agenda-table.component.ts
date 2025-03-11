import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agenda-table',
  imports: [],
  templateUrl: './agenda-table.component.html',
  styleUrl: './agenda-table.component.css'
})
export class AgendaTableComponent implements OnInit{

  // Variables para mostrar las horas en el horario de la agenda
  schedule:String[] = [ "00:00", "02:00", "04:00", "06:00", "08:00", "10:00",
                        "12:00", "14:00", "16:00", "18:00", "20:00", "22:00",
                      ];

  ngOnInit(): void {
    
  }



}
