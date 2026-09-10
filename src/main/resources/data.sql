--
-- CARGA DE DADOS DE TESTE: PRODUTOS (EQUIPAMENTOS)
--
INSERT INTO produto (id, numero_serie, modelo, linha_producao, data_fabricacao)
VALUES (1, 'MOT-2026-9901', 'Motor Trifásico W22 50HP', 'Linha Alta Tensão 02', '2026-02-15');
INSERT INTO produto (id, numero_serie, modelo, linha_producao, data_fabricacao)
VALUES (2, 'MOT-2026-9902', 'Motor Antideflagrante W22Xdb', 'Linha Ambientes Explosivos',
'2026-01-20');
INSERT INTO produto (id, numero_serie, modelo, linha_producao, data_fabricacao)
VALUES (3, 'GER-2026-5001', 'Gerador Industrial Diesel GTA-500kW', 'Linha de Geradores
Pesados', '2025-11-10');
INSERT INTO produto (id, numero_serie, modelo, linha_producao, data_fabricacao)
VALUES (4, 'SRV-2026-1040', 'Servomotor de Alta Precisão SWA-40', 'Linha de Automação
Robótica', '2026-03-01');
INSERT INTO produto (id, numero_serie, modelo, linha_producao, data_fabricacao)
VALUES (5, 'MOT-2026-9903', 'Motor Monofásico NEMA Premium 10HP', 'Linha Comercial Leve',
'2026-02-28');
--
-- CARGA DE DADOS DE TESTE: DOCUMENTOS TÉCNICOS
--
-- Documentos do Produto 1 (MOT-2026-9901)
INSERT INTO documento_tecnico (id, produto_id, tipo, titulo, url_arquivo, versao)
VALUES (1, 1, 'MANUAL', 'Manual de Instalação e Operação W22',
'https://docs.fabrica.com/manuais/w22.pdf', 'v2.1');
INSERT INTO documento_tecnico (id, produto_id, tipo, titulo, url_arquivo, versao)
VALUES (2, 1, 'DATASHEET', 'Folha de Dados Técnicos Curva de Torque W22',
'https://docs.fabrica.com/datasheets/w22-50hp.pdf', 'v1.0');
-- Documentos do Produto 2 (MOT-2026-9902)
INSERT INTO documento_tecnico (id, produto_id, tipo, titulo, url_arquivo, versao)
VALUES (3, 2, 'MANUAL', 'Guia de Segurança em Áreas Classificadas ATEX',
'https://docs.fabrica.com/manuais/atex-w22xdb.pdf', 'v3.0');
INSERT INTO documento_tecnico (id, produto_id, tipo, titulo, url_arquivo, versao)
VALUES (4, 2, 'DIAGRAMA_ELETRICO', 'Esquema de Ligação da Caixa de Bornes Ex',
'https://docs.fabrica.com/esquemas/w22xdb-bornes.pdf', 'v1.2');
-- Documentos do Produto 3 (GER-2026-5001)
INSERT INTO documento_tecnico (id, produto_id, tipo, titulo, url_arquivo, versao)
VALUES (5, 3, 'MANUAL', 'Manual de Manutenção Preventiva do Alternador',
'https://docs.fabrica.com/manuais/gta500-maint.pdf', 'v1.5');
INSERT INTO documento_tecnico (id, produto_id, tipo, titulo, url_arquivo, versao)
VALUES (6, 3, 'DATASHEET', 'Especificação de Consumo de Combustível e Potência',
'https://docs.fabrica.com/datasheets/gta500.pdf', 'v2.0');
-- Documentos do Produto 4 (SRV-2026-1040)
INSERT INTO documento_tecnico (id, produto_id, tipo, titulo, url_arquivo, versao)
VALUES (7, 4, 'DIAGRAMA_ELETRICO', 'Pinagem de Controle Encoder Resolver',
'https://docs.fabrica.com/esquemas/swa40-pinout.pdf', 'v1.0');
--
-- CARGA DE DADOS DE TESTE: CERTIFICADOS
--
-- Certificados do Produto 1 (MOT-2026-9901)
INSERT INTO certificado (id, produto_id, numero_emissao, orgao_emissor, data_emissao,
data_validade)
VALUES (1, 1, 'CERT-ISO-8821', 'Bureau Veritas', '2026-01-10', '2029-01-10');
INSERT INTO certificado (id, produto_id, numero_emissao, orgao_emissor, data_emissao,
data_validade)
VALUES (2, 1, 'CERT-INMETRO-2026-04', 'TÜV Rheinland', '2026-02-01', '2028-02-01');
-- Certificados do Produto 2 (MOT-2026-9902)
INSERT INTO certificado (id, produto_id, numero_emissao, orgao_emissor, data_emissao,
data_validade)
VALUES (3, 2, 'CERT-ATEX-EX-9902', 'DNV GL Europe', '2026-01-05', '2031-01-05');
INSERT INTO certificado (id, produto_id, numero_emissao, orgao_emissor, data_emissao,
data_validade)
VALUES (4, 2, 'CERT-IECEX-2026-88', 'DEKRA Certification', '2026-01-15', '2031-01-15');
-- Certificados do Produto 3 (GER-2026-5001)
INSERT INTO certificado (id, produto_id, numero_emissao, orgao_emissor, data_emissao,
data_validade)
VALUES (5, 3, 'CERT-CE-MARK-2025', 'SGS Group', '2025-11-20', '2028-11-20');
-- Certificados do Produto 4 (SRV-2026-1040)
INSERT INTO certificado (id, produto_id, numero_emissao, orgao_emissor, data_emissao,
data_validade)
VALUES (6, 4, 'CERT-UL-ROBOTICS-01', 'Underwriters Laboratories (UL)', '2026-02-10',
'2030-02-10');