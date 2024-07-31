import fetch from "node-fetch";
import cheerio from "cheerio";

const URL = `https://docs.google.com/document/d/e/2PACX-1vSHesOf9hv2sPOntssYrEdubmMQm8lwjfwv6NPjjmIRYs_FOYXtqrYgjh85jBUebK9swPXh_a5TJ5Kl/pub`;

const decodeMessage = () => {
  fetchGoogleDoc(URL);

  try {
  } catch (error) {
    console.error("Error fetching or processing the data:", error);
  }
};

const fetchGoogleDoc = async (url) => {
  const response = await fetch(url);
  const text = await response.text();

  const { xKeys, yKeys, maxX, maxY, frequency_map } = createFreqMap(text);
  console.log({ xKeys, yKeys, maxX, maxY });
  // Print the grid
  printGrid(maxY, maxX, frequency_map);
};

const printGrid = (maxY, maxX, frequency_map) => {
  for (let x = 0; x <= maxY; x++) {
    let row = "";
    for (let y = 0; y <= maxX; y++) {
      row +=
        frequency_map[y] && frequency_map[y][x] ? frequency_map[y][x] : " ";
    }
    console.log(row);
  }
};

const createFreqMap = (text) => {
  // cheerio is for parsing the HTML
  const $ = cheerio.load(text);

  const frequency_map = {};

  const rows = $("tr");

  rows.each((index, row) => {
    const columns = $(row).find("td");
    if (columns.length === 3) {
      const x = parseInt($(columns[0]).text().trim());
      const char = $(columns[1]).text().trim();
      const y = parseInt($(columns[2]).text().trim());

      // Populate the frequency_map with the coordinates and character
      if (!frequency_map[x]) {
        frequency_map[x] = {};
      }
      frequency_map[x][y] = char;
    }
  });

  const xKeys = Object.keys(frequency_map)
    .map((key) => parseInt(key))
    .filter((k) => !isNaN(k));
  const yKeys = Object.values(frequency_map)
    .map((row) => Object.keys(row).map((key) => parseInt(key)))
    .flat()
    .filter((k) => !isNaN(k));

  const maxY = Math.max(...yKeys);
  const maxX = Math.max(...xKeys);
  return { xKeys, yKeys, maxX, maxY, frequency_map };
};

decodeMessage();
