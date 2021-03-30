import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-loops',
  templateUrl: './loops.component.html',
  styleUrls: ['./loops.component.css']
})
export class LoopsComponent implements OnInit {
  names = [
    {name: 'Volkan', id: 1, money: 200 , role:'manager'},
    {name: 'Huseyin', id: 1, money: 12 , role: 'admin'},
    {name: 'Ayse', id: 1, money: 600, role: 'user'}
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

}
