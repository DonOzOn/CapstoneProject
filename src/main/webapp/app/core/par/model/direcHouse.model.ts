export interface IDirecHouse {
  id?: any;
  name_par?: String;
  sinhkhi?: String;
  thieny?: String;
  diennien?: String;
  phucvi?: String;
  tuyetmenh?: String;
  nguquy?: String;
  lucsat?: String;
  hoahai?: String;
}

export class DirecHouse implements IDirecHouse {
  constructor(
    public id?: any,
    public name_par?: String,
    public sinhkhi?: String,
    public thieny?: String,
    public diennien?: String,
    public phucvi?: String,
    public tuyetmenh?: String,
    public nguquy?: String,
    public lucsat?: String,
    public hoahai?: String
  ) {
    this.id = id ? id : null;
    this.name_par = name_par ? name_par : null;
    this.sinhkhi = sinhkhi ? sinhkhi : null;
    this.thieny = thieny ? thieny : null;
    this.diennien = diennien ? diennien : null;
    this.phucvi = phucvi ? phucvi : null;
    this.tuyetmenh = tuyetmenh ? tuyetmenh : null;
    this.nguquy = nguquy ? nguquy : null;
    this.lucsat = lucsat ? lucsat : null;
    this.hoahai = hoahai ? hoahai : null;
  }
}
